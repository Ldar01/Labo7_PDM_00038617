package tech.visuallatam.laboratorio7_00038617.Database.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tech.visuallatam.laboratorio7_00038617.Database.Entities.GitHubRepo
import tech.visuallatam.laboratorio7_00038617.Database.Repositories.GitHubRepoRepository
import tech.visuallatam.laboratorio7_00038617.Database.RoomDB

class GitHubRepoViewModel(app: Application): AndroidViewModel(app){

    private val repository:GitHubRepoRepository

    init {
        val repoDao = RoomDB.getInstance(app).repoDAO()
        repository = GitHubRepoRepository(repoDao)
    }

    fun getAll() : LiveData<List<GitHubRepo>> = repository.getAll()

    fun insert(repo: GitHubRepo) = viewModelScope.launch (Dispatchers.IO){ repository.insert(repo) }

}