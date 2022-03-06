<template>
  <div>
    <div><span style="font-weight: bolder">全部留言</span></div>
    <hr style="color: #8f8f8f">
    <div class="my-2 mx-2" v-for="(comment,id) in comments" v-bind:key="id">
      <div class="my-2 titler">{{ comment.username }}</div>
      <div class="ms-1 mt-1 content">&nbsp;{{ comment.content }}</div>
      <div class="w-100" style="display: flex">
        <div style="margin-left: auto;font-size: 12px;color: #8c939d" class="ms-auto ttt"><span
            class="me-2">{{ comment.time }}</span><span class="reply" @click="reply(comment)">回复</span></div>
      </div>
      <div>
        <div v-for="(child, id2) in comment.children" :key="id2" class="ms-5">
          <div class="titler">{{ child.username }}</div>
          <div class="ms-1 mt-1 content">&nbsp;{{ child.content }}</div>
          <div class="w-100" style="display: flex">
            <div style="margin-left: auto;font-size: 12px;color: #8c939d" class="ms-auto ttt"><span
                class="me-2">{{ child.time }}</span><span class="reply" @click="reply(child)">回复</span></div>
          </div>
        </div>
      </div>
      <hr style="color: #8f8f8f">
    </div>
    <div class="mt-5">
      <span class=""  ref="replyContent">留言</span>
      <el-input class="mt-2" v-model="email" placeholder="邮箱（可不填）"></el-input>
      <el-input class="mt-2"
                type="textarea"
                :rows="2"
                placeholder="留言"
                v-model="content">
      </el-input>
      <el-button type="primary" class="mt-2">发表</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "CommentArea",
  data() {
    return {
      comments: [
        {
          cid: "12321",
          username: "innnky",
          content: "原型助手是一款功能强大的原型设计工具。原型助手是一款功能强大的原型设计工具。原型助手是一款功能强大的原型设计工具。原型助手是一款功能强大的原型设计工具。",
          time: "2022.3.6 10:21",
          children: [
            {
              cid: "12321",
              username: "innnky",
              content: "原型助手是一款功能强大的原型设计工具。原型助手是一款功能强大的原型设计工具。原型助手是一款功能强大的原型设计工具。原型助手是一款功能强大的原型设计工具。",
              time: "2022.3.6 10:21",
            }
          ]
        },
        {
          cid: "12321",
          username: "innnky",
          content: "原型助手是一款功能强大的原型设计工具。原型助手是一款功能强大的原型设计工具。原型助手是一款功能强大的原型设计工具。原型助手是一款功能强大的原型设计工具。",
          time: "2022.3.6 10:21",
          children: []
        },
      ],
      email:'',
      content: "",
      replyCid: ""

    }
  },
  methods: {
    reply(target) {
      this.$refs.replyContent.scrollIntoView(true);
      this.content = "回复 " + target.username+ ":"
      this.replyCid = target.cid;
    }
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