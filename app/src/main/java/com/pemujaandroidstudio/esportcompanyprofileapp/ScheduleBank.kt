package com.pemujaandroidstudio.esportcompanyprofileapp

import java.time.LocalDateTime

data class ScheduleBank(var dateAndTime: LocalDateTime,
                        var title: String,
                        var game: String,
                        var team: String,
                        var location: String,
                        var description: String,
                        var image: String)