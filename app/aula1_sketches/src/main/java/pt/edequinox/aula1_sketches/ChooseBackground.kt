package pt.edequinox.aula1_sketches

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview;
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

//@Composable
//fun ChooseBackground(sketchTitle: MutableState<String>,
//                     colorR: MutableState<Int>,
//                     colorG: MutableState<Int>,
//                     colorB: MutableState<Int>,
//                     modifier: Modifier = Modifier
//) {
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseBackground(viewModel: DrawingViewModel,
                     modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        OutlinedTextField(value = viewModel.sketchTitle.value,
            label = { Text(stringResource(id = R.string.title)) },
            onValueChange = {
                viewModel.sketchTitle.value = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .border(1.dp, color = Color.Gray, RoundedCornerShape(4.dp))) {
            ChoseSolidColor(viewModel.colorR,
                viewModel.colorG,
                viewModel.colorB)
        }

    }


}

@Composable
fun ChoseSolidColor(colorR: MutableState<Int>,
                    colorG: MutableState<Int>,
                    colorB: MutableState<Int>) {
    Column{
        SliderWithTitle(title = "R",
            value = colorR.value,
            onValueChange = {
                colorR.value = it
            },
            max = 255,
            sliderColor = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Red,
                inactiveTrackColor = Color.Red.copy(alpha = 0.5f)
            ),
            modifier = Modifier.fillMaxWidth()
        )
        SliderWithTitle(title = "G",
            value = colorG.value,
            onValueChange = {
                colorG.value = it
            },
            max = 255,
            sliderColor = SliderDefaults.colors(
                thumbColor = Color.Green,
                activeTrackColor = Color.Green,
                inactiveTrackColor = Color.Green.copy(alpha = 0.5f)
            ),
            modifier = Modifier.fillMaxWidth()
        )
        SliderWithTitle(title = "B",
            value = colorB.value,
            onValueChange = {
                colorB.value = it
            },
            max = 255,
            sliderColor = SliderDefaults.colors(
                thumbColor = Color.Blue,
                activeTrackColor = Color.Blue,
                inactiveTrackColor = Color.Blue.copy(alpha = 0.5f)
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Box(modifier = Modifier.background(Color(colorR.value, colorG.value, colorB.value))
            .fillMaxWidth()
            .aspectRatio(1f))
    }

}



@Composable
fun SliderWithTitle(title: String,
                    value: Int,
                    onValueChange: (Int) -> Unit,
                    max: Int,
                    sliderColor: SliderColors,
                    modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = modifier) {
        Text(text = title
            , modifier = Modifier.padding(8.dp))
        Slider(
            value = value.toFloat() / max.toFloat(),
            onValueChange = { onValueChange((it * max).toInt())},
            colors = sliderColor,
        )

    }
}


@Preview(showBackground = true
    , backgroundColor = 0xFFFFFFFF
    , showSystemUi = true
    , name = "Choose Background Preview")
@Composable
fun ChooseBackgroundPreview() {
    ChooseBackground(DrawingViewModel())
}