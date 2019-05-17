package tech.visuallatam.laboratorio7_00038617.Database.Repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import tech.visuallatam.laboratorio7_00038617.Database.Daos.GitHubRepoDAO
import tech.visuallatam.laboratorio7_00038617.Database.Entities.GitHubRepo

class GitHubRepoRepository(private val repoDAO: GitHubRepoDAO){

    fun getAll(): LiveData<List<GitHubRepo>> = repoDAO.getAll()

    fun nuke()= repoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(repo: GitHubRepo) =  repoDAO.insert(repo)


}