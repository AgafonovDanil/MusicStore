package com.example.musicStore

data class start(val name:String, val hello:String, val image: Int)

object List {
    val list = arrayListOf(
        start(
            "Лучшее обороудование",
            "Огромный выбор музыкальных инструментов на любой вкус!",
            R.drawable.logostart
        ),
        start ("Лучшие цены", "Звук, свет, мультимедиа оборудование для объектов любой сложности!",
            R.drawable.explorestart
        ),

        start ("Быстрее света", "Быстрая и качественная доставка!", R.drawable.warnstart)

    )
}
