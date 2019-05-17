package tech.visuallatam.laboratorio7_00038617.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.repo_cardview.view.*
import tech.visuallatam.laboratorio7_00038617.Database.Entities.GitHubRepo
import tech.visuallatam.laboratorio7_00038617.R

class ReposAdapter(var repos: List<GitHubRepo>) : RecyclerView.Adapter<ReposAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.repo_cardview, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  repos.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(repos[p1])
    }

    fun updateList(newRepos: List<GitHubRepo>){
        this.repos = newRepos
        notifyDataSetChanged()
    }


    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(repo : GitHubRepo) = with(itemView){
            tv_repo_name.text = repo.name
        }
    }

}