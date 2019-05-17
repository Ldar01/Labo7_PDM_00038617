package tech.visuallatam.laboratorio7_00038617

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import tech.visuallatam.laboratorio7_00038617.Adapters.ReposAdapter
import tech.visuallatam.laboratorio7_00038617.Database.Entities.GitHubRepo
import tech.visuallatam.laboratorio7_00038617.Database.ViewModels.GitHubRepoViewModel

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ReposAdapter
    lateinit var viewModel: GitHubRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun bind(){
        adapter = ReposAdapter(ArrayList())
        viewModel = ViewModelProviders.of(this).get(GitHubRepoViewModel::class.java)
        rv_repos.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        viewModel.getAll().observe(this, Observer {
            adapter.updateList(it)
        })
        btn_add.setOnClickListener {
            viewModel.insert(GitHubRepo(et_repo_name.text.toString()))
        }
    }

}
