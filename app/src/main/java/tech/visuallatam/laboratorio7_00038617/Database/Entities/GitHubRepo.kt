package tech.visuallatam.laboratorio7_00038617.Database.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos")
data class GitHubRepo(
    val name: String
){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}