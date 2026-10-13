package com.example.ktgk_21115053120316_phantanhung

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_21115053120316_phantanhung.databinding.ActivityChinhSuaChiTieuBinding
import com.example.ktgk_21115053120316_phantanhung.utils.KEY_KHOAN_CHI_316
import com.example.ktgk_21115053120316_phantanhung.utils.hienThongBao_316
import com.example.ktgk_21115053120316_phantanhung.utils.layKhoanChi_316

class ChinhSuaChiTieuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChinhSuaChiTieuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChinhSuaChiTieuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val khoanChiCu_316 = intent.layKhoanChi_316(KEY_KHOAN_CHI_316)
        if (khoanChiCu_316 == null) {
            hienThongBao_316("Không nhận được dữ liệu khoản chi")
            finish()
            return
        }

        binding.edtTenKhoanChi316.setText(khoanChiCu_316.tenKhoanChi)
        binding.edtSoTien316.setText(khoanChiCu_316.soTien.toLong().toString())
        binding.edtGhiChu316.setText(khoanChiCu_316.ghiChu)

        binding.btnLuu316.setOnClickListener {
            val khoanChiMoi_316 = khoanChiCu_316.copy(
                tenKhoanChi = binding.edtTenKhoanChi316.text.toString().trim(),
                soTien = binding.edtSoTien316.text.toString().trim().toDoubleOrNull()
                    ?: khoanChiCu_316.soTien,
                ghiChu = binding.edtGhiChu316.text.toString().trim()
            )
            val ketQua_316 = Intent().apply { putExtra(KEY_KHOAN_CHI_316, khoanChiMoi_316) }
            setResult(Activity.RESULT_OK, ketQua_316)
            finish()
        }

        // Huy: chi finish(), khong setResult nen du lieu ban dau khong doi
        binding.btnHuy316.setOnClickListener { finish() }
    }
}