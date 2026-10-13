package com.example.ktgk_21115053120316_phantanhung
package com.hung.ktgk

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_21115053120316_phantanhung.databinding.ActivityMainBinding
import com.example.ktgk_21115053120316_phantanhung.utils.hienThongBao_316
import com.example.ktgk_21115053120316_phantanhung.utils.kiemTraSoTien_316
import com.example.ktgk_21115053120316_phantanhung.utils.kiemTraTen_316

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnThemKhoanChi316.setOnClickListener { xuLyThem_316() }
        binding.btnXemChiTiet316.setOnClickListener {
            startActivity(Intent(this, ChiTietChiTieuActivity::class.java))
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