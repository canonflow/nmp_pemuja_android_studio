package com.pemujaandroidstudio.esportcompanyprofileapp

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object AchievementData {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    var achievements: Array<AchievementBank> = arrayOf(
        AchievementBank(
            achievement = "Champions of the Regional Valorant Showdown",
            time = LocalDateTime.of(2023, 1, 1, 0, 0), // Using January 1st as a default date
            team = "Team A",
            game = "Valorant"
        ),
        AchievementBank(
            achievement = "Best Defensive Team Award",
            time = LocalDateTime.of(2024, 1, 1, 0, 0),
            team = "Team A",
            game = "Valorant"
        ),
        AchievementBank(
            achievement = "MVP of the Season",
            time = LocalDateTime.of(2023, 1, 1, 0, 0),
            team = "Team B",
            game = "Valorant"
        ),
        AchievementBank(
            achievement = "Flawless Victory at the Spring Valorant Cup",
            time = LocalDateTime.of(2022, 1, 1, 0, 0),
            team = "Team A",
            game = "Valorant"
        ),
        AchievementBank(
            achievement = "Top 4 Finish in the International Valorant Championship",
            time = LocalDateTime.of(2023, 1, 1, 0, 0),
            team = "Team C",
            game = "Valorant"
        )
    )
}