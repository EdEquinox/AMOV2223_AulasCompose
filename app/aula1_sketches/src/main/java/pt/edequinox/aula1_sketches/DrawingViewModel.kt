package pt.edequinox.aula1_sketches

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlin.random.Random
import kotlin.random.nextInt

data class DrawingClass(val color: Color, val points: List<Offset>)

class DrawingViewModel : ViewModel(){

    val sketchTitle = mutableStateOf("")
    val colorR = mutableStateOf(128)
    val colorG = mutableStateOf(0)
    val colorB = mutableStateOf(128)

    private val _lines = mutableListOf<DrawingClass>()

    val lines : List<DrawingClass>
        get() = _lines
    fun addLine(
        color: Color = Color(
            Random.nextInt(0..255),Random.nextInt(0..255),Random.nextInt(0..255)),
        points: List<Offset>
    ) {
        _lines.add(DrawingClass(color, points.toList()))
    }


}
