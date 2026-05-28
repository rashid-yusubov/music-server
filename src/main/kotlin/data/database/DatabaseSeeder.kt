package com.rashidyusubov.musicserver.data.database

import com.rashidyusubov.musicserver.data.database.tables.AlbumsTable
import com.rashidyusubov.musicserver.data.database.tables.ArtistsTable
import com.rashidyusubov.musicserver.data.database.tables.TracksTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseSeeder {

    fun seed() {

        transaction {

            val hasTracks = TracksTable
                .selectAll()
                .count() > 0

            if (hasTracks) return@transaction

            // =====================================
            // Imagine Dragons
            // =====================================

            ArtistsTable.insert {

                it[name] = "Imagine Dragons"

                it[avatarUrl] = null

                it[description] = "American pop rock band"
            }

            AlbumsTable.insert {

                it[title] = "Evolve"

                it[artistId] = 1

                it[coverUrl] = null

                it[releaseYear] = 2017
            }

            val imagineDragonsTracks = listOf(
                "Next To Me" to "imagine_dragons_next_to_me.mp3",
                "I Don't Know Why" to "imagine_dragons_i_dont_know_why.mp3",
                "Whatever It Takes" to "imagine_dragons_whatever_it_takes.mp3",
                "Believer" to "imagine_dragons_believer.mp3",
                "Walking The Wire" to "imagine_dragons_walking_the_wire.mp3",
                "Rise Up" to "imagine_dragons_rise_up.mp3",
                "I'll Make It Up To You" to "imagine_dragons_ill_make_it_up_to_you.mp3",
                "Yesterday" to "imagine_dragons_yesterday.mp3",
                "Mouth Of The River" to "imagine_dragons_mouth_of_the_river.mp3",
                "Thunder" to "imagine_dragons_thunder.mp3",
                "Start Over" to "imagine_dragons_start_over.mp3",
                "Dancing In The Dark" to "imagine_dragons_dancing_in_the_dark.mp3"
            )

            imagineDragonsTracks.forEach { (title, fileName) ->

                TracksTable.insert {

                    it[TracksTable.title] = title

                    it[artistId] = 1

                    it[albumId] = 1

                    it[duration] = 200

                    it[genre] = "Pop Rock"

                    it[audioUrl] = "/music/$fileName"

                    it[coverUrl] = null
                }
            }

            // =====================================
            // The Weeknd
            // =====================================

            ArtistsTable.insert {

                it[name] = "The Weeknd"

                it[avatarUrl] = null

                it[description] = "Canadian singer and songwriter"
            }

            AlbumsTable.insert {

                it[title] = "Starboy"

                it[artistId] = 2

                it[coverUrl] = null

                it[releaseYear] = 2016
            }

            val weekndTracks = listOf(
                "Starboy" to "the_weeknd_starboy.mp3",
                "Party Monster" to "the_weeknd_party_monster.mp3",
                "False Alarm" to "the_weeknd_false_alarm.mp3",
                "Reminder" to "the_weeknd_reminder.mp3",
                "Rockin'" to "the_weeknd_rockin.mp3",
                "Secrets" to "the_weeknd_secrets.mp3",
                "True Colors" to "the_weeknd_true_colors.mp3",
                "Sidewalks" to "the_weeknd_sidewalks.mp3",
                "Six Feet Under" to "the_weeknd_six_feet_under.mp3",
                "Love To Lay" to "the_weeknd_love_to_lay.mp3",
                "A Lonely Night" to "the_weeknd_a_lonely_night.mp3",
                "Attention" to "the_weeknd_attention.mp3",
                "Ordinary Life" to "the_weeknd_ordinary_life.mp3",
                "Nothing Without You" to "the_weeknd_nothing_without_you.mp3",
                "All I Know" to "the_weeknd_all_i_know.mp3",
                "Die For You" to "the_weeknd_die_for_you.mp3",
                "I Feel It Coming" to "the_weeknd_i_feel_it_coming.mp3"
            )

            weekndTracks.forEach { (title, fileName) ->

                TracksTable.insert {

                    it[TracksTable.title] = title

                    it[artistId] = 2

                    it[albumId] = 2

                    it[duration] = 220

                    it[genre] = "R&B"

                    it[audioUrl] = "/music/$fileName"

                    it[coverUrl] = null
                }
            }

            // =====================================
            // The Rolling Stones
            // =====================================

            ArtistsTable.insert {

                it[name] = "The Rolling Stones"

                it[avatarUrl] = null

                it[description] = "English rock band"
            }

            AlbumsTable.insert {

                it[title] = "Aftermath"

                it[artistId] = 3

                it[coverUrl] = null

                it[releaseYear] = 1966
            }

            val rollingStonesTracks = listOf(
                "Paint It, Black" to "the_rolling_stones_paint_it_black.mp3",
                "Stupid Girl" to "the_rolling_stones_stupid_girl.mp3",
                "Lady Jane" to "the_rolling_stones_lady_jane.mp3",
                "Under My Thumb" to "the_rolling_stones_under_my_thumb.mp3",
                "Doncha Bother Me" to "the_rolling_stones_doncha_bother_me.mp3",
                "Think" to "the_rolling_stones_think.mp3",
                "Flight 505" to "the_rolling_stones_flight_505.mp3",
                "High And Dry" to "the_rolling_stones_high_and_dry.mp3",
                "It's Not Easy" to "the_rolling_stones_its_not_easy.mp3",
                "I Am Waiting" to "the_rolling_stones_i_am_waiting.mp3",
                "Going Home" to "the_rolling_stones_going_home.mp3"
            )

            rollingStonesTracks.forEach { (title, fileName) ->

                TracksTable.insert {

                    it[TracksTable.title] = title

                    it[artistId] = 3

                    it[albumId] = 3

                    it[duration] = 210

                    it[genre] = "Rock"

                    it[audioUrl] = "/music/$fileName"

                    it[coverUrl] = null
                }
            }

            // =====================================
            // Kiss
            // =====================================

            ArtistsTable.insert {

                it[name] = "Kiss"

                it[avatarUrl] = null

                it[description] = "American hard rock band"
            }

            AlbumsTable.insert {

                it[title] = "Killers"

                it[artistId] = 4

                it[coverUrl] = null

                it[releaseYear] = 1982
            }

            val kissTracks = listOf(
                "I'm A Legend Tonight" to "kiss_im_a_legend_tonight.mp3",
                "Down On Your Knees" to "kiss_down_on_your_knees.mp3",
                "Cold Gin" to "kiss_cold_gin.mp3",
                "Love Gun" to "kiss_love_gun.mp3",
                "Shout It Out Loud" to "kiss_shout_it_out_loud.mp3",
                "Escape From The Island" to "kiss_escape_from_the_island.mp3",
                "Talk To Me" to "kiss_talk_to_me.mp3",
                "Sure Know Something" to "kiss_sure_know_something.mp3",
                "Nowhere To Run" to "kiss_nowhere_to_run.mp3",
                "Partners In Crime" to "kiss_partners_in_crime.mp3",
                "Detroit Rock City" to "kiss_detroit_rock_city.mp3",
                "God Of Thunder" to "kiss_god_of_thunder.mp3",
                "I Was Made For Lovin' You" to "kiss_i_was_made_for_lovin_you.mp3",
                "Shandi" to "kiss_shandi.mp3",
                "Rock And Roll All Nite" to "kiss_rock_and_roll_all_nite_live.mp3"
            )

            kissTracks.forEach { (title, fileName) ->

                TracksTable.insert {

                    it[TracksTable.title] = title

                    it[artistId] = 4

                    it[albumId] = 4

                    it[duration] = 215

                    it[genre] = "Hard Rock"

                    it[audioUrl] = "/music/$fileName"

                    it[coverUrl] = null
                }
            }
        }
    }
}