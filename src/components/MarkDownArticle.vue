<template>
<div>
  <div class="markdown-body">
    <vue-markdown :source="content"></vue-markdown>
  </div>
</div>
</template>

<script>
import VueMarkdown from 'vue-markdown'
import 'github-markdown-css/github-markdown.css'
export default {
  components: {
    VueMarkdown // 注入组件
  },
  name: "MarkDownArticle",
  props:{
    content:String
  }
}
</script>

<style scoped>

</style>