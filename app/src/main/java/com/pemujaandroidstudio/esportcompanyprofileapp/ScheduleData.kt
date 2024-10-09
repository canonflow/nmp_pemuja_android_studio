package com.pemujaandroidstudio.esportcompanyprofileapp

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object ScheduleData {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    var schedules: Array<ScheduleBank> = arrayOf(
        ScheduleBank(LocalDateTime.parse("2024-09-05 10:00:00", formatter),"Regional Qualifier - Valorant","Valorant", "Team A", "Los Angeles, CA", "This high-stakes event will bring togther top teams from across the region, all competing for a chance to advance to the national finals. Expect intense gameplay, strategic, plays, and thrilling moments as teams battle it out in one of the most popular first-person shooters.\\n\\nFans can anticipate an action-packed day filled with memorable highlights and fierce competition in the heart of the e-sports scene."),
        ScheduleBank(LocalDateTime.parse("2024-09-10 10:00:00", formatter),"League of Legends Workshop","LOL", "Team C", "Los Angeles, CA", "This high-stakes event will bring togther top teams from across the region, all competing for a chance to advance to the national finals. Expect intense gameplay, strategic, plays, and thrilling moments as teams battle it out in one of the most popular first-person shooters.\\n\\nFans can anticipate an action-packed day filled with memorable highlights and fierce competition in the heart of the e-sports scene."),
        ScheduleBank(LocalDateTime.parse("2024-10-07 10:00:00", formatter),"Call of Duty Championship","COD", "Team A", "Los Angeles, CA", "This high-stakes event will bring togther top teams from across the region, all competing for a chance to advance to the national finals. Expect intense gameplay, strategic, plays, and thrilling moments as teams battle it out in one of the most popular first-person shooters.\\n\\nFans can anticipate an action-packed day filled with memorable highlights and fierce competition in the heart of the e-sports scene."),
        ScheduleBank(LocalDateTime.parse("2024-11-11 10:00:00", formatter),"Dota2 Livestream","Dota2", "Team B", "Los Angeles, CA", "This high-stakes event will bring togther top teams from across the region, all competing for a chance to advance to the national finals. Expect intense gameplay, strategic, plays, and thrilling moments as teams battle it out in one of the most popular first-person shooters.\\n\\nFans can anticipate an action-packed day filled with memorable highlights and fierce competition in the heart of the e-sports scene."),
        ScheduleBank(LocalDateTime.parse("2024-12-04 10:00:00", formatter),"Fortnite Invitational","Fortnite", "Team A", "Los Angeles, CA", "This high-stakes event will bring togther top teams from across the region, all competing for a chance to advance to the national finals. Expect intense gameplay, strategic, plays, and thrilling moments as teams battle it out in one of the most popular first-person shooters.\\n\\nFans can anticipate an action-packed day filled with memorable highlights and fierce competition in the heart of the e-sports scene."))
}