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
        ),
        // Mobile Legends
        AchievementBank(
            achievement = "1st Runner Up MPL Singapore Season 8",
            time = LocalDateTime.of(2024, 9, 7, 0, 0),
            team = "Team A",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "Champions MDL Philippines Season 4",
            time = LocalDateTime.of(2024, 8, 27, 0, 0),
            team = "Team B",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "Top 5 Japan Community Cup Season 3",
            time = LocalDateTime.of(2024, 7, 20, 0, 0),
            team = "Team C",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "Champions MLBB Japan League",
            time = LocalDateTime.of(2023, 12, 30, 0, 0),
            team = "Team A",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "1st Runner Up Sultan Cup Rising Star",
            time = LocalDateTime.of(2023, 12, 20, 0, 0),
            team = "Team B",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "2nd Runner Up Moroccan Pro League Season 6",
            time = LocalDateTime.of(2023, 10, 27, 0, 0),
            team = "Team A",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "Champions MLBB Indonesia Community Cup Season 1",
            time = LocalDateTime.of(2023, 11, 15, 0, 0),
            team = "Team C",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "Top 10 Kohai Infiniti Championship Season 2",
            time = LocalDateTime.of(2023, 11, 2, 0, 0),
            team = "Team B",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "2nd Runner Up MPL MENA Fall 2023",
            time = LocalDateTime.of(2023, 9, 8, 0, 0),
            team = "Team C",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "Champions Kohai SEA Championship Season 2",
            time = LocalDateTime.of(2022, 11, 22, 0, 0),
            team = "Team A",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "1st Runner Up PlayGalaxy Tournament",
            time = LocalDateTime.of(2022, 12, 14, 0, 0),
            team = "Team A",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "Top 3 M5 World Championship",
            time = LocalDateTime.of(2022, 11, 23, 0, 0),
            team = "Team B",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "MVP of Kohai Sea Championship Season 2 Wildcard",
            time = LocalDateTime.of(2022, 11, 27, 0, 0),
            team = "Team B",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "Champions MDL Indonesia Season 8",
            time = LocalDateTime.of(2022, 7, 10, 0, 0),
            team = "Team C",
            game = "Mobile Legends"
        ),
        AchievementBank(
            achievement = "1st Runner Up Malaysia Esports League 2023",
            time = LocalDateTime.of(2022, 10, 27, 0, 0),
            team = "Team C",
            game = "Mobile Legends"
        ),
        // Dota 2
        AchievementBank(
            achievement = "Champions ESL One Bangkok 2024",
            time = LocalDateTime.of(2024, 12, 9, 0, 0),
            team = "Team A",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "1st Runner Up DreamLeague Season 24",
            time = LocalDateTime.of(2024, 11, 27, 0, 0),
            team = "Team A",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "Top 5 Clavision: Snow Ruyi",
            time = LocalDateTime.of(2024, 7, 28, 0, 0),
            team = "Team B",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "2nd Runner Up DreamLeague Season 23",
            time = LocalDateTime.of(2024, 5, 20, 0, 0),
            team = "Team B",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "Top 8 Elite League Season 1",
            time = LocalDateTime.of(2024, 3, 31, 0, 0),
            team = "Team C",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "Champions BetBoom Dacha Dubai 2024",
            time = LocalDateTime.of(2024, 2, 24, 0, 0),
            team = "Team C",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "Champions ESL One Kuala Lumpur 2023",
            time = LocalDateTime.of(2023, 12, 11, 0, 0),
            team = "Team A",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "2nd Runner Up The International 2023",
            time = LocalDateTime.of(2023, 10, 12, 0, 0),
            team = "Team A",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "1st Runner Up DreamLeague Season 21",
            time = LocalDateTime.of(2023, 9, 18, 0, 0),
            team = "Team B",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "Top 5 Riyadh Masters 2023",
            time = LocalDateTime.of(2023, 7, 19, 0, 0),
            team = "Team B",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "2nd Runner Up DreamLeague Season 20",
            time = LocalDateTime.of(2023, 6, 11, 0, 0),
            team = "Team C",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "Top 5 Lima Major 2023",
            time = LocalDateTime.of(2023, 2, 22, 0, 0),
            team = "Team C",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "Champions The International 2022",
            time = LocalDateTime.of(2022, 10, 15, 0, 0),
            team = "Team A",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "1st Runner Up PGL Arlington Major 2022",
            time = LocalDateTime.of(2022, 8, 4, 0, 0),
            team = "Team A",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "Champions ESL One Stockholm Major 2022",
            time = LocalDateTime.of(2022, 5, 12, 0, 0),
            team = "Team B",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "2nd Runner Up ESL One Malaysia 2022",
            time = LocalDateTime.of(2022, 8, 23, 0, 0),
            team = "Team B",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "Champions Riyadh Masters 2022",
            time = LocalDateTime.of(2022, 7, 20, 0, 0),
            team = "Team C",
            game = "Dota 2"
        ),
        AchievementBank(
            achievement = "Top 10 GAMERS GALAXY: Invitational Series Dubai 2022",
            time = LocalDateTime.of(2022, 3, 2, 0, 0),
            team = "Team C",
            game = "Dota 2"
        ),
    )
}