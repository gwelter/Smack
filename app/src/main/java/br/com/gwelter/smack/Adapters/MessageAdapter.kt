package br.com.gwelter.smack.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.gwelter.smack.Model.ChatMessage
import br.com.gwelter.smack.R
import br.com.gwelter.smack.Services.UserDataService
import org.w3c.dom.Text

/**
 * Created by guilherme on 05/11/17.
 */
class MessageAdapter(val context: Context, val messages: ArrayList<ChatMessage>) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindMessage(context, messages[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.message_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return messages.count()
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val userImage = itemView?.findViewById<ImageView>(R.id.messageUserImage)
        val timestamp = itemView?.findViewById<TextView>(R.id.messageTimeStampLabel)
        val userName = itemView?.findViewById<TextView>(R.id.messageUserNameLabel)
        val messageBody = itemView?.findViewById<TextView>(R.id.messageBodyLabel)

        fun bindMessage(context: Context, message: ChatMessage) {
            val resourceID = context.resources.getIdentifier(message.userAvatar, "drawable", context.packageName)
            userImage?.setImageResource(resourceID)
            userImage?.setBackgroundColor(UserDataService.returnAvatarColor(message.userAvatarColor))

            userName?.text = message.userName
            timestamp?.text = message.timestamp
            messageBody?.text = message.message
        }
    }
}