package com.example.ktgk_21115053120316_phantanhung

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_21115053120316_phantanhung.databinding.ActivityChiTietChiTieuBinding
import com.example.ktgk_21115053120316_phantanhung.repository.KhoanChi
import com.example.ktgk_21115053120316_phantanhung.utils.KEY_KHOAN_CHI_316
import com.example.ktgk_21115053120316_phantanhung.utils.hienThongBao_316
import com.example.ktgk_21115053120316_phantanhung.utils.kiemTraTen_316
import com.example.ktgk_21115053120316_phantanhung.utils.layKhoanChi_316

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChiTietChiTieuBinding
    private var khoanChi_316: KhoanChi? = null

    private val chinhSuaLauncher_316 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua_316 ->
        if (ketQua_316.resultCode == Activity.RESULT_OK) {
            ketQua_316.data?.layKhoanChi_316(KEY_KHOAN_CHI_316)?.let { moi_316 ->
                khoanChi_316 = moi_316
                hienThi_316()
                hienThongBao_316("Đã lưu chỉnh sửa")
            }
        } else {
            hienThongBao_316("Đã hủy chỉnh sửa, dữ liệu giữ nguyên")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietChiTieuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        khoanChi_316 = intent.layKhoanChi_316(KEY_KHOAN_CHI_316)
        hienThi_316()
        kiemTraDuLieu_316()

        binding.btnChinhSua316.setOnClickListener { moManHinhChinhSua_316() }
        binding.btnQuayLai316.setOnClickListener { finish() }
    }

    private fun kiemTraDuLieu_316() {
        val khoanChi_316 = khoanChi_316
        if (khoanChi_316 == null || !kiemTraTen_316(khoanChi_316.tenKhoanChi)) {
            hienThongBao_316("Không nhận được tên khoản chi")
        }
        if (khoanChi_316 == null || !khoanChi_316.laSoTienHopLe()) {
            hienThongBao_316("Số tiền không hợp lệ")
        }
    }

    private fun hienThi_316() {
        val khoanChi_316 = khoanChi_316 ?: return
        binding.tvTenKhoanChi316.text = "Tên khoản chi: ${khoanChi_316.tenKhoanChi}"
        binding.tvSoTien316.text = "Số tiền: ${khoanChi_316.soTien.toLong()} VNĐ"
        binding.tvGhiChu316.text = "Ghi chú: ${khoanChi_316.ghiChu}"
        binding.tvTrangThai316.text =
            if (khoanChi_316.daThanhToan) "Trạng thái: Đã thanh toán"
            else "Trạng thái: Chưa thanh toán"
    }

    private fun moManHinhChinhSua_316() {
        val khoanChi_316 = khoanChi_316 ?: return
        val intent_316 = Intent(this, ChinhSuaChiTieuActivity::class.java).apply {
            putExtra(KEY_KHOAN_CHI_316, khoanChi_316)
        }
        chinhSuaLauncher_316.launch(intent_316)
    }
}