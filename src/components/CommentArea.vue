<template>
  <div>
    <div><span style="font-weight: bolder">全部留言</span></div>
    <hr style="color: #8f8f8f">
    <div class="my-2 mx-2" v-for="(comment,id) in commentData" v-bind:key="id">
      <div class="my-2 titler">{{ comment.email }}</div>
      <div class="ms-1 mt-1 content">&nbsp;{{ comment.content }}</div>
      <div class="w-100" style="display: flex">
        <div style="margin-left: auto;font-size: 12px;color: #8c939d" class="ms-auto ttt"><span
            class="me-2">{{ comment.publishedTime }}</span><span class="reply" @click="reply(comment)">回复</span></div>
      </div>
      <div>
        <div v-for="(child, id2) in comment.children" :key="id2" class="ms-5">
          <div class="titler">{{ child.email }}</div>
          <div class="ms-1 mt-1 content">&nbsp;{{ child.content }}</div>
          <div class="w-100" style="display: flex">
            <div style="margin-left: auto;font-size: 12px;color: #8c939d" class="ms-auto ttt"><span
                class="me-2">{{ child.publishedTime }}</span><span class="reply" @click="replyC(comment,child)">回复</span></div>
          </div>
        </div>
      </div>
      <hr style="color: #8f8f8f">
    </div>
    <div v-if="commentData.length===0">暂无数据</div>
    <div class="mt-5">
      <span class=""  ref="replyContent">留言</span>
      <el-input class="mt-2" v-model="email" placeholder="邮箱或用户名（可不填）"></el-input>
      <el-input class="mt-2"
                type="textarea"
                :rows="2"
                :placeholder="liuyan"
                v-model="content">
      </el-input>
      <el-button type="primary" class="mt-2" @click="send()">发表</el-button>
    </div>
  </div>
</template>

<script>
import {getCommentByArticle, insertComment} from "@/api/data";

export default {
  name: "CommentArea",
  data() {
    return {
      email:'',
      content: "",
      replyCid: "",
      commentData:[
      ],
      liuyan:"留言"
    }
  },
  methods: {
    reply(target) {
      this.$refs.replyContent.scrollIntoView(true);
      this.liuyan = "回复 " + target.email+ ":"
      this.replyCid = target.id;

    },
    replyC(comment,child){
      this.$refs.replyContent.scrollIntoView(true);
      this.content = "回复 " + child.email+ ":"
      this.replyCid = comment.id;
    },
    send(){
      const sentEmail = this.email==='' ?"匿名":this.email;
      if (this.content ===''){
        this.$message("请输入内容再发表！")
        return
      }
      insertComment({
        'email':sentEmail,
        'content': this.content,
        "parentId":this.replyCid,
        "articleId":this.articleId
      }).then(()=>{
        getCommentByArticle(this.articleId).then((res)=>{
          this.commentData = res.data
          this.content=''
          this.replyCid=''
          this.email = ''
          this.liuyan = '回复'
        })
      })
    }
  },
  created() {
    getCommentByArticle(this.articleId).then((res)=>{
      this.commentData = res.data
      console.log(res);
    })
  },
  props:{
    articleId:String
  }
}
</script>

<style scoped>
div {
  font-family: 新宋体, serif;
}

.ttt {
  font-family: Arial, sans-serif;
}

.reply:hover {
  color: #1e1e1e;
  cursor: pointer;
}


</style>