package com.pemujaandroidstudio.esportcompanyprofileapp

import java.time.LocalDateTime

data class AchievementBank(
    var achievement: String,
    var time: LocalDateTime,
    var team: String,
    var game: String
)