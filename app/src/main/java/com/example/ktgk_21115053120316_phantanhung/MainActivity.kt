package com.example.ktgk_21115053120316_phantanhung

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_21115053120316_phantanhung.databinding.ActivityMainBinding
import com.example.ktgk_21115053120316_phantanhung.utils.hienThongBao_316
import com.example.ktgk_21115053120316_phantanhung.utils.kiemTraSoTien_316
import com.example.ktgk_21115053120316_phantanhung.utils.kiemTraTen_316
import  com.example.ktgk_21115053120316_phantanhung.utils.KEY_GHI_CHU_316
import  com.example.ktgk_21115053120316_phantanhung.utils.KEY_SO_TIEN_316
import  com.example.ktgk_21115053120316_phantanhung.utils.KEY_TEN_316
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(binding.root)
        title = "Phan Tấn Hùng - 21115053120316 - Quản lý chi tiêu cá nhân"

        binding.btnThemKhoanChi316.setOnClickListener { xuLyThem_316() }
        binding.btnXemChiTiet316.setOnClickListener {
            val intent_316 = Intent(this, ChiTietChiTieuActivity::class.java).apply {
                putExtra(KEY_TEN_316, binding.edtTenKhoanChi316.text.toString().trim())
                putExtra(KEY_SO_TIEN_316, binding.edtSoTien316.text.toString().trim())
                putExtra(KEY_GHI_CHU_316, binding.edtGhiChu316.text.toString().trim())
            }
            startActivity(intent_316)
        }
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
        hienThongBao_316("Đã thêm khoản chi: ${ten_316.trim()}")
    }
}