package com.example.ktgk_21115053120316_phantanhung


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_21115053120316_phantanhung.databinding.ActivityChiTietChiTieuBinding
import com.example.ktgk_21115053120316_phantanhung.utils.KEY_GHI_CHU_316
import com.example.ktgk_21115053120316_phantanhung.utils.KEY_SO_TIEN_316
import com.example.ktgk_21115053120316_phantanhung.utils.KEY_TEN_316
import com.example.ktgk_21115053120316_phantanhung.utils.hienThongBao_316
import com.example.ktgk_21115053120316_phantanhung.utils.kiemTraSoTien_316
import com.example.ktgk_21115053120316_phantanhung.utils.kiemTraTen_316
import android.content.Intent
import android.app.Activity
import androidx.activity.result.contract.ActivityResultContracts

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChiTietChiTieuBinding
    private var ten_316 = ""
    private var soTien_316 = ""
    private var ghiChu_316 = ""
    private val chinhSuaLauncher_316 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { ketQua_316 ->
        if (ketQua_316.resultCode == Activity.RESULT_OK) {
            ketQua_316.data?.let { duLieu_316 ->
                ten_316 = duLieu_316.getStringExtra(KEY_TEN_316).orEmpty()
                soTien_316 = duLieu_316.getStringExtra(KEY_SO_TIEN_316).orEmpty()
                ghiChu_316 = duLieu_316.getStringExtra(KEY_GHI_CHU_316).orEmpty()
                hienThi_316()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChiTietChiTieuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnQuayLai316.setOnClickListener { finish() }
        binding.btnChinhSua316.setOnClickListener { moManHinhChinhSua_316() }

        ten_316 = intent.getStringExtra(KEY_TEN_316).orEmpty()
        soTien_316 = intent.getStringExtra(KEY_SO_TIEN_316).orEmpty()
        ghiChu_316 = intent.getStringExtra(KEY_GHI_CHU_316).orEmpty()
        hienThi_316()
        if (!kiemTraTen_316(ten_316)) {
            hienThongBao_316("Không nhận được tên khoản chi")
        }
        if (!kiemTraSoTien_316(soTien_316)) {
            hienThongBao_316("Số tiền không hợp lệ")
        }

    }

    private fun hienThi_316() {
        binding.tvTenKhoanChi316.text = "Tên khoản chi: $ten_316"
        binding.tvSoTien316.text = "Số tiền: $soTien_316"
        binding.tvGhiChu316.text = "Ghi chú: $ghiChu_316"
    }
    private fun moManHinhChinhSua_316() {
        val intent_316 = Intent(this, ChinhSuaChiTieuActivity::class.java).apply {
            putExtra(KEY_TEN_316, ten_316)
            putExtra(KEY_SO_TIEN_316, soTien_316)
            putExtra(KEY_GHI_CHU_316, ghiChu_316)
        }
        chinhSuaLauncher_316.launch(intent_316)
    }
}
