@Composable
fun Task() {
    var stroke =""
    var space =0
    val result = StringBuilder()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Введите строку")

        TextField(
            value = stroke,
            onValueChange = { newText ->
                    stroke = newText
                    result.clear()
                    for (i in 0.. stroke.length) {
                        when (stroke[i]) {
                            in '0'..'9' -> result.append(' ')
                            else -> result.append(stroke[i])
                        }
                    }
                    space =0
                    for(i in 0..stroke.length){
                        if(stroke[i]==' '){
                            space ++
                        }
                    }

            },
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text("Измененная строка: $stroke")
        Text("Количество пробелов: $space")
    }
}
