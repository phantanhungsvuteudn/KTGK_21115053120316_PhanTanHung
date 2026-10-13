package com.example.ktgk_21115053120316_phantanhung.utils

import android.content.Context
import android.widget.Toast

fun kiemTraTen_316(ten_316: String): Boolean = ten_316.isNotBlank()

fun kiemTraSoTien_316(chuoi_316: String): Boolean {
    val so_316 = chuoi_316.trim().toDoubleOrNull()
    return so_316 != null && so_316 > 0
}

fun Context.hienThongBao_316(noiDung_316: String) {
    Toast.makeText(this, noiDung_316, Toast.LENGTH_SHORT).show()
}