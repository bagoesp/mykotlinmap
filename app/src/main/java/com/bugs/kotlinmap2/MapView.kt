package com.bugs.kotlinmap2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MapView(context: Context, attrs: AttributeSet): View(context, attrs) {

    lateinit var cells: Array<Array<Cell>>
    private val COLS = 5
    private val ROWS = 4
    private val wallPaint: Paint = Paint()
    private val WALL_THICKNESS = 4F

    init {
        wallPaint.color = Color.BLACK
        wallPaint.strokeWidth = WALL_THICKNESS
        createMap()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawColor(Color.WHITE)

        val cellSize = width/(COLS+1)

        val hMargin = (width - COLS*cellSize)/2
        val vMargin = (height - ROWS*cellSize)/2

        canvas.translate(hMargin.toFloat(), vMargin.toFloat())

        for (x in 0 until COLS) {
            for (y in 0 until ROWS) {
                if (cells[x][y].top)
                    canvas.drawLine(
                        x*cellSize.toFloat(),
                        y*cellSize.toFloat(),
                        (x+1)*cellSize.toFloat(),
                        y*cellSize.toFloat(),
                        wallPaint
                    )

                if (cells[x][y].left)
                    canvas.drawLine(
                        x*cellSize.toFloat(),
                        y*cellSize.toFloat(),
                        x*cellSize.toFloat(),
                        (y+1)*cellSize.toFloat(),
                        wallPaint
                    )

                if (cells[x][y].bottom)
                    canvas.drawLine(
                        x*cellSize.toFloat(),
                        (y+1)*cellSize.toFloat(),
                        (x+1)*cellSize.toFloat(),
                        (y+1)*cellSize.toFloat(),
                        wallPaint
                    )

                if (cells[x][y].right)
                    canvas.drawLine(
                        (x+1)*cellSize.toFloat(),
                        y*cellSize.toFloat(),
                        (x+1)*cellSize.toFloat(),
                        (y+1)*cellSize.toFloat(),
                        wallPaint
                    )
            }
        }
    }

    private fun createMap() {

        cells = Array(COLS) {
            Array(ROWS) {
                Cell()
            }
        }

        for (x in 0 until COLS) {
            for (y in 0 until ROWS) {
                cells[x][y].x = x
                cells[x][y].y = y
            }
        }

        // COLUMNS 0,1,2,3,4
        // ROW 0
        // 0,0
        cells[0][0].top = true
        cells[0][0].left = true
        // 1,0
        cells[1][0].top = true
        cells[1][0].right = true
        // 2,0
        cells[2][0].top = true
        cells[2][0].left = true
        cells[2][0].right = true
        // 3,0
        cells[3][0].top = true
        cells[3][0].left = true
        // 4,0
        cells[4][0].top = true
        cells[4][0].right = true

        // COLUMNS 0,1,2,3,4
        // ROW 1
        // 0,1
        cells[0][1].left = true
        cells[0][1].bottom = true
        // 1,1
        cells[1][1].bottom = true
        // cells[1][1].right = true
        // 2,1
        cells[2][1].left = true
        cells[2][1].right = true
        // 3,1
        cells[3][1].bottom = true
        cells[3][1].left = true
        // 4,1
        cells[4][1].bottom = true
        cells[4][1].right = true

        // COLUMNS 0,1,2,3,4
        // ROW 2
        // 0,2
        cells[0][2].left = true
        cells[0][2].top = true
        // 1,2
        cells[1][2].top = true
        cells[1][2].right = true
        // 2,2
        cells[2][2].left = true
        cells[2][2].right = true
        // 3,2
        cells[3][2].top = true
        cells[3][2].left = true
        // 4,2
        cells[4][2].top = true
        cells[4][2].right = true

        // COLUMNS 0,1,2,3,4
        // ROW 3
        // 0,3
        cells[0][3].left = true
        cells[0][3].bottom = true
        // 1,3
        cells[1][3].bottom = true
        cells[1][3].right = true
        // 2,3
        cells[2][3].left = true
        cells[2][3].bottom = true
        cells[2][3].right = true
        // 3,3
        // cells[3][3].left = true
        cells[3][3].bottom = true
        // 4,3
        cells[4][3].bottom = true
        cells[4][3].right = true
    }

}