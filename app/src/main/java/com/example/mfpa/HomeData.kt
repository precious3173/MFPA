package com.example.mfpa

data class HomeData (
    var characterImage: Int, var characterName: String, var isFavourite: Boolean
        )

object precious {

    private val characterImages = arrayListOf(
        R.drawable.jiraya, R.drawable.nagato, R.drawable.sasori, R.drawable.shikamaru,
        R.drawable.danzo, R.drawable.obito, R.drawable.orochimaru, R.drawable.kisame,
        R.drawable.tobirama, R.drawable.urashiki, R.drawable.sasori, R.drawable.danzo

    )

    private val characterNames = arrayListOf(
        "Jiraya", "Nagato", "Sasori", "Shikamaru",
        "Danzo", "Obito", "Orochimaru", "Kisame",
        "Tobirama", "Urashiki", "Sasori", "Danzo"
    )

    var animeList : ArrayList<HomeData>? = null
    get() {
        if (field != null)
            return field

        field = ArrayList()

        for (i in characterImages.indices){

            val characterImage = characterImages[i]
            val characterName = characterNames[i]
            val anime = HomeData(characterImage, characterName, false)

            field!!.add(anime)
        }

        return field
    }

 var favouriteCharacter: MutableList<HomeData> = mutableListOf()
}