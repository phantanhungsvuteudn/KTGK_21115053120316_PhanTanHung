package com.example.ktgk_21115053120316_phantanhung


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ktgk_21115053120316_phantanhung.databinding.ActivityChinhSuaChiTieuBinding
import com.example.ktgk_21115053120316_phantanhung.utils.KEY_GHI_CHU_316
import com.example.ktgk_21115053120316_phantanhung.utils.KEY_SO_TIEN_316
import com.example.ktgk_21115053120316_phantanhung.utils.KEY_TEN_316
import android.app.Activity
import android.content.Intent

class ChinhSuaChiTieuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChinhSuaChiTieuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChinhSuaChiTieuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.edtTenKhoanChi316.setText(intent.getStringExtra(KEY_TEN_316))
        binding.edtSoTien316.setText(intent.getStringExtra(KEY_SO_TIEN_316))
        binding.edtGhiChu316.setText(intent.getStringExtra(KEY_GHI_CHU_316))
        binding.btnLuu316.setOnClickListener {
            val ketQua_316 = Intent().apply {
                putExtra(KEY_TEN_316, binding.edtTenKhoanChi316.text.toString().trim())
                putExtra(KEY_SO_TIEN_316, binding.edtSoTien316.text.toString().trim())
                putExtra(KEY_GHI_CHU_316, binding.edtGhiChu316.text.toString().trim())
            }
            setResult(Activity.RESULT_OK, ketQua_316)
            finish()
        }

        binding.btnHuy316.setOnClickListener { finish() }
    }
}