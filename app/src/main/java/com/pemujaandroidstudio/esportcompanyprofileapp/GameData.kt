package com.pemujaandroidstudio.esportcompanyprofileapp

object GameData {
    var games: Array<GameBank> = arrayOf(
        GameBank(
            "Valorant",
            "Valorant is a free-to-play first-person tactical shooter developed and published by Riot Games. Players engage in strategic, team-based matches where they must complete objectives and outsmart opponents to win.",
            R.drawable.banner_valorant
        ),
        GameBank(
            "Mobile Legends",
            "Mobile Legends: Bang Bang is a multiplayer online battle arena (MOBA) game designed for mobile phones. The game is free-to-play and is only monetized through in-game purchases like characters and skins. Each player can control a selectable character, called a Hero, with unique abilities and traits. There are six roles that define the main purpose of heroes: Tank, Marksman, Assassin, Fighter, Mage, and Support. These roles determine the responsibilities of players for their respective teams. Players can also set specific builds for heroes which include in-game items and emblems.",
            R.drawable.banner_mobile_legends
        ),
        GameBank(
            "Dota 2",
            "Dota 2 is a multiplayer online battle arena (MOBA) video game in which two teams of five players compete to destroy a large structure defended by the opposing team known as the \"Ancient\" whilst defending their own. As in Defense of the Ancients, the game is controlled using standard real-time strategy controls, and is presented on a single map in a three-dimensional isometric perspective.\n\nTen players each control one of the game's 125 playable characters, known as \"heroes\", with each having their own design, strengths, and weaknesses. Heroes are divided into two primary roles, known as the core and support.",
            R.drawable.banner_dota_2
        )
    )
}