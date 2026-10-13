package com.example.ktgk_21115053120316_phantanhung.repository

import java.io.Serializable

data class KhoanChi(
    val maKhoanChi: String,
    var tenKhoanChi: String,
    var soTien: Double,
    var ghiChu: String,
    var daThanhToan: Boolean,
    var loaiChi: String = "Khác"
) : Serializable {

    fun layThongTin(): String {
        val trangThai_316 = if (daThanhToan) "Đã thanh toán" else "Chưa thanh toán"
        return "[$maKhoanChi] ($loaiChi) $tenKhoanChi - ${soTien.toLong()} VNĐ - $trangThai_316 (Ghi chú: $ghiChu)"
    }

    fun laSoTienHopLe(): Boolean = soTien > 0
}