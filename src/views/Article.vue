<template>
  <div class="main-container flex-column" style="display:flex;">
    <common-header class="w-100 position-fixed" style="z-index: 1000"/>

    <div class="web-bg " :style="bgstyle"></div>
    <h3 class="mytitle mb-3" style="text-align: left" ref="titleee">{{atitle}}</h3>
    <div style="width: 100%;">
      <div class="content row justify-content-center w-100 m-0" >
        <!--    <div></div>-->
        <div class="col-md-10">
          <div style="background:#fff;padding: 40px;box-shadow: 0px 0px 30px rgba(107,74,82,0.39);
              border-radius: 2px;min-height: 500px">
            <mark-down-article :content="articleContent">

            </mark-down-article>
            <comment-area/>
          </div>
        </div>
        

      </div>
      <common-footer style="margin-top: 30px"/>
    </div>

  </div>
</template>

<script>
import CommonHeader from "@/components/CommonHeader";
import CommonFooter from "@/components/CommonFooter";
import CommentArea from "@/components/CommentArea";
import MarkDownArticle from "@/components/MarkDownArticle";
import {getArticleDetail} from "@/api/data";

export default {
  name: "Article",
  components: {
    MarkDownArticle:MarkDownArticle,
    CommonHeader: CommonHeader,
    CommonFooter: CommonFooter,
    CommentArea: CommentArea

  },
  data() {
    return {
      bgstyle: {
        backgroundImage: 'url(http://home.innky.xyz:25566/images/9888608.png)',
      },
      articleContent:"",
      atitle:""
    }
  },
  methods: {},
  created() {
    const aid = this.$route.params.aid;
    getArticleDetail(aid).then((res)=>{
      this.articleContent = res.data.content
      this.atitle = res.data.title
      // console.log(res);
    })
  },
  mounted() {
    // this.$refs.titleee.scrollIntoView();
    window.scroll(0,1)
  }
}
</script>

<style scoped>
.web-bg {
  position: fixed;
  z-index: -999;
  width: 100%;
  height: 100%;
  background: url(https://pic1.rpgsky.net/imgcn/2020/11/28/2c4da137c8111983b5be3707ef53980c.png);
  background-attachment: local;
  background-position: center;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  background-size: cover;
  background-repeat: no-repeat;
}

.mytitle {
  font-size: 40px;
  font-family: 宋体, serif;
  color: #3f001c;
  font-weight: lighter;
  margin-left: 10%;
  margin-top: 160px;
  /*margin-top: 3px;*/
}


div {
  font-family: Arial, serif;
}
</style>
