package pt.edequinox.aula1_sketches

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DrawingScreen(viewModel: DrawingViewModel,
                  modifier: Modifier = Modifier
) {

    val pointList = remember { mutableStateListOf<Offset>() }

    Box(modifier = modifier
        .fillMaxSize()
        .pointerInteropFilter {
            when (it.action) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                    pointList.add(Offset(it.x, it.y))
                    true
                }
                MotionEvent.ACTION_UP -> {
                    //viewModel.addLine(pointList)
                    pointList.clear()
                    true
                }
                else -> false
            }
        }
        .background(
            Color(
                viewModel.colorR.value,
                viewModel.colorG.value,
                viewModel.colorB.value
            )
        ) ) {

        Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
            if (viewModel.lines.isNotEmpty()){
                for (line in viewModel.lines){
                    var old = pointList[0]
                    drawLine(
                        color = line.color,
                        start = line.points[0],
                        end = line.points[1],
                        strokeWidth = 5f
                    )
                }
            }
            if (pointList.size > 0){
                var old = pointList[0]
                for(point in pointList){
                    drawLine(
                        color = Color.Black,
                        start = old,
                        end = point,
                        strokeWidth = 5f
                    )
                    old = point
                }
            }
            }
        )
    }

}
@Preview
@Composable
fun DrawingScreenPreview() {
    DrawingScreen(viewModel = DrawingViewModel())
}
