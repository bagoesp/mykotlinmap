package com.bugs.kotlinmap2

data class Cell(
    var x: Int = 0,
    var y: Int = 0,
    var top: Boolean = false,
    var right: Boolean = false,
    var bottom: Boolean = false,
    var left: Boolean = false,
)
