package com.example.ktgk_21115053120316_phantanhung


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_21115053120316_phantanhung.databinding.ActivityChiTietChiTieuBinding
import com.example.ktgk_21115053120316_phantanhung.utils.KEY_GHI_CHU_316
import com.example.ktgk_21115053120316_phantanhung.utils.KEY_SO_TIEN_316
import com.example.ktgk_21115053120316_phantanhung.utils.KEY_TEN_316

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChiTietChiTieuBinding
    private var ten_316 = ""
    private var soTien_316 = ""
    private var ghiChu_316 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietChiTieuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ten_316 = intent.getStringExtra(KEY_TEN_316).orEmpty()
        soTien_316 = intent.getStringExtra(KEY_SO_TIEN_316).orEmpty()
        ghiChu_316 = intent.getStringExtra(KEY_GHI_CHU_316).orEmpty()
        hienThi_316()
    }

    private fun hienThi_316() {
        binding.tvTenKhoanChi316.text = "Tên khoản chi: $ten_316"
        binding.tvSoTien316.text = "Số tiền: $soTien_316"
        binding.tvGhiChu316.text = "Ghi chú: $ghiChu_316"
    }
}