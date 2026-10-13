package com.example.ktgk_21115053120316_phantanhung

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_21115053120316_phantanhung.databinding.ActivityMainBinding
import com.example.ktgk_21115053120316_phantanhung.repository.KhoanChi
import com.example.ktgk_21115053120316_phantanhung.utils.KEY_KHOAN_CHI_316
import com.example.ktgk_21115053120316_phantanhung.utils.hienThongBao_316
import com.example.ktgk_21115053120316_phantanhung.utils.kiemTraSoTien_316
import com.example.ktgk_21115053120316_phantanhung.utils.kiemTraTen_316
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var demMa_316 = 0
    private val dsLoaiChi_316 = listOf("Ăn uống", "Đi lại", "Học tập", "Khác")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.spLoaiChi316.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            dsLoaiChi_316
        )
        title = "Phan Tấn Hùng - 21115053120316 - Quản lý chi tiêu cá nhân"

        napDuLieuMau_316()

        binding.btnThemKhoanChi316.setOnClickListener { xuLyThem_316() }
        binding.btnXemChiTiet316.setOnClickListener {
            val intent_316 = Intent(this, ChiTietChiTieuActivity::class.java).apply {
                putExtra(KEY_KHOAN_CHI_316, taoKhoanChi_316())
            }
            startActivity(intent_316)
        }
    }

    // Du lieu khoi tao rieng cua sinh vien (hay doi thanh noi dung cua ban)
    private fun napDuLieuMau_316() {
        binding.edtTenKhoanChi316.setText("Mua tai nghe Bluetooth Soundcore")
        binding.edtSoTien316.setText("459000")
        binding.edtGhiChu316.setText("Mua tai Hoa Khanh, Da Nang")
    }

    private fun taoKhoanChi_316(): KhoanChi {
        demMa_316++
        return KhoanChi(
            maKhoanChi = "HUNG316-%02d".format(demMa_316),
            tenKhoanChi = binding.edtTenKhoanChi316.text.toString().trim(),
            soTien = binding.edtSoTien316.text.toString().trim().toDoubleOrNull() ?: 0.0,
            ghiChu = binding.edtGhiChu316.text.toString().trim(),
            daThanhToan = false,
            loaiChi = binding.spLoaiChi316.selectedItem.toString()
        )
    }

    private fun xuLyThem_316() {
        val ten_316 = binding.edtTenKhoanChi316.text.toString()
        val soTien_316 = binding.edtSoTien316.text.toString()
        if (!kiemTraTen_316(ten_316)) {
            hienThongBao_316("Tên khoản chi không được để trống")
            return
        }
        if (!kiemTraSoTien_316(soTien_316)) {
            hienThongBao_316("Số tiền không hợp lệ")
            return
        }
        val khoanChi_316 = taoKhoanChi_316()
        hienThongBao_316("Đã thêm: ${khoanChi_316.layThongTin()}")
    }
}