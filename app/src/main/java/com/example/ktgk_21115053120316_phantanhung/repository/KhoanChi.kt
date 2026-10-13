package com.example.ktgk_21115053120316_phantanhung.repository


import java.io.Serializable

data class KhoanChi(
    val maKhoanChi: String,
    var tenKhoanChi: String,
    var soTien: Double,
    var ghiChu: String,
    var daThanhToan: Boolean
) : Serializable