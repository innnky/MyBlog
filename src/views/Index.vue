<template>
  <div class="main-container" >
    <common-header style="position: fixed;left: 0;top: 0; width: 100%;z-index: 1000"></common-header>
    <section class="imgsm hidden-md-and-up" :style="bgstyle">
      <div style="width: 80%; margin-left: auto;margin-right: auto;margin-top: auto">
        <h1 class="titles"> innnky的个人博客</h1>
        <p style="font-size: 18px;line-height: 40px;font-family: 宋体,serif;">
          &nbsp;&nbsp;本博客主要以记录日常学习笔记为主。前端为vue+elementui开发，后端由springboot开发，为本人学习java web开发的练习项目</p>
      </div>
    </section>
    <section class="imgmd hidden-sm-and-down" :style="bgstyle">
      <div style="width: 30%; margin-left: auto;margin-right: 100px">
        <h1 class="title"> innnky的个人博客</h1>
        <p style="font-size: 18px;line-height: 40px;font-family: 宋体,serif;">
          &nbsp;&nbsp;本博客主要以记录日常学习笔记为主。前端为vue+elementui开发，后端由springboot开发，为本人学习java web开发的练习项目</p></div>
    </section>
    <section
        style="height: 400px; background:#ffe8eb;width: 100%;display:flex; align-items: center;justify-content: space-around;
box-shadow: 0 0 30px rgba(246,186,186,0.1)">
      <div style="width: 40%;margin-left: 100px" class="hidden-xs-only">
        <h3 class="title" style="margin-top: 5px"> 最近文章 </h3>
        <p class="linktext" style="font-size: 20px" v-for="article in recentDtoArticles" :key="article" @click="handleArticleDetail(article.id)">{{ article.title }}</p>
        <span class="linktext">查看更多</span>
      </div>
      <div style="width: 80%;margin-left: 10px" class="hidden-sm-and-up">
        <h3 class="title" style="margin-top: 5px"> 最近文章 </h3>
        <p class="linktext" style="font-size: 20px" v-for="article in recentDtoArticles" :key="article" @click="handleArticleDetail(article.id)">{{ article.title }}</p>
        <span class="linktext">查看更多</span>
      </div>
      <img :src="allArtileImg" class="hidden-xs-only" alt="i" style="width: 30%">
    </section>
    <section
        style="height: 400px; background:#ffffff;width: 100%;display:flex; align-items: center;justify-content: space-around">
      <img :src="classArticleImg"  class="hidden-xs-only" alt="i" style="width: 30%;margin-left: 100px">
      <div style="width: 40%;margin-left: 60px" class="hidden-xs-only">
        <h3 class="title"> 分类 </h3>
        <p class="linktext" style="font-size: 20px" v-for="type in types" :key="type">{{ type }}</p>
        <span class="linktext">全部分类</span>
      </div>
      <div style="width: 80%" class="hidden-sm-and-up">
        <h3 class="title"> 分类 </h3>
        <p class="linktext" style="font-size: 20px" v-for="type in types" :key="type">{{ type }}</p>
        <span class="linktext">全部分类</span>
      </div>

    </section>
    <section
        style="background:#ffe8eb;">

      <div style="width: 100%;display:flex; align-items: center;justify-content: space-evenly">
<!--        <el-row style="width: 100%;" gutter="30">-->
<!--&lt;!&ndash;          <el-col :sm="8" v-for="item in inf" :key="item.title" style="margin-bottom: 20px;margin-top: 20px">&ndash;&gt;-->
<!--&lt;!&ndash;          </el-col>&ndash;&gt;-->
<!--        </el-row  >-->
        <div class="container m-4">
          <div class="row">
            <div class="col-md-4 mb-4" v-for="item in personalInf" :key="item.title">
              <el-card class="box-card" shadow="hover">
                <div slot="header" class="clearfix">
                  <span>{{ item.title }}</span>
                  <el-button style="float: right; padding: 3px 0" type="text">前往</el-button>
                </div>
                <div style="">
                  <div class="row justify-content-center">
                    <div class="col-4 col-md-6 ">
                      <img :src="item.img" class="avatar img-thumbnail" >

                    </div>
                  </div>
                  <div class="row mt-2">
                    <div class="col ">
                      <div style="margin-left: 40px" class="text item">
                        <p class="aaaaaxx">{{ item.id }}</p>
                        <p class="aaaaaxx">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad animi asperiores </p>
                        <!--                <p class="aaaaaxx">{{ item.id }}</p>-->
                      </div>
                    </div>
                  </div>
                </div>
              </el-card>
            </div>
          </div>
        </div>

      </div>
    </section>
    <section
        style="height: 200px; background:#ffffff;width: 100%;display:flex; align-items: center;justify-content: center">
      <div style="display:flex;">
        <div style="width: 50px;line-height: 40px" class="hidden-xs-only">留言</div>
        <el-input v-model="input" placeholder="请输入内容" style="width: 80%"></el-input>
        <el-button style="margin-left: 20px">发表</el-button>
      </div>
    </section>
    <common-footer/>
  </div>
</template>

<script>
import CommonHeader from "@/components/CommonHeader";
import CommonFooter from "@/components/CommonFooter";
import { getIndexInformation} from "@/api/data";
export default {
  name: "index",
  components: {
    CommonHeader: CommonHeader,
    CommonFooter: CommonFooter

  },
  methods:{
    handleArticleDetail(aid){
      console.log(aid);
      this.$router.push({
        path:`/article/${aid}`
      })
    }
  },
  created() {
    this.loading = true
    getIndexInformation().then((res)=>{
      console.log(res);
      this.recentDtoArticles = res.data.recentDtoArticles;
      this.personalInf = res.data.personalInf;
      this.types = res.data.types;
      this.loading = false
    })
  },
  data() {
    return {
      allArtileImg: require('@/assets/undraw.svg'),
      bgstyle: {
        backgroundImage: 'url(' + require('@/assets/art.jpg') + ')',
      },
      bgimg2: 'url(' + require('@/assets/9888608.png') + ')',
      classArticleImg: require('@/assets/un.svg'),
      recentDtoArticles: [],
      types: [
        '前端',
        '后端',
        'javase'
      ],
      personalInf: [
        {
          title: "Bilibili",
          id: "Rcell",
          link: "https://space.bilibili.com/343303724",
          img: "https://img2.baidu.com/it/u=268699178,2128593682&fm=253&fmt=auto&app=138&f=JPEG?w=496&h=500"

        },
        {
          title: "Github",
          id: "innnky",
          link: "https://github.com/innnky",
          img: "https://img1.baidu.com/it/u=2703487632,963885301&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"

        },
        {
          title: "QQ",
          id: "洗衣机",
          link: "https://space.bilibili.com/343303724",
          img: "https://img2.baidu.com/it/u=268699178,2128593682&fm=253&fmt=auto&app=138&f=JPEG?w=496&h=500"

        }
      ]
    }
  }
}
</script>

<style scoped>
.main-container {
  font-family: 宋体, serif;
  /*background-color: #FFC8CE;*/
  /*background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='100' height='100' viewBox='0 0 200 200'%3E%3Cdefs%3E%3ClinearGradient id='a' gradientUnits='userSpaceOnUse' x1='100' y1='33' x2='100' y2='-3'%3E%3Cstop offset='0' stop-color='%23000' stop-opacity='0'/%3E%3Cstop offset='1' stop-color='%23000' stop-opacity='1'/%3E%3C/linearGradient%3E%3ClinearGradient id='b' gradientUnits='userSpaceOnUse' x1='100' y1='135' x2='100' y2='97'%3E%3Cstop offset='0' stop-color='%23000' stop-opacity='0'/%3E%3Cstop offset='1' stop-color='%23000' stop-opacity='1'/%3E%3C/linearGradient%3E%3C/defs%3E%3Cg fill='%23daa5ab' fill-opacity='0.6'%3E%3Crect x='100' width='100' height='100'/%3E%3Crect y='100' width='100' height='100'/%3E%3C/g%3E%3Cg fill-opacity='0.5'%3E%3Cpolygon fill='url(%23a)' points='100 30 0 0 200 0'/%3E%3Cpolygon fill='url(%23b)' points='100 100 0 130 0 100 200 100 200 130'/%3E%3C/g%3E%3C/svg%3E");*/
  /*background-size: 1000px;*/
  /*font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;*/

}

.avatar {
  border-radius: 50%;
}

.title {
  font-size: 50px;
  font-family: 宋体, serif;
  color: #3f001c;
  font-weight: lighter;
  margin-top: 3px;
}
.titles{
  font-size: 50px;
  font-family: 宋体, serif;
  color: #3f001c;
  font-weight: lighter;
  margin-bottom: 10px;
}
.aaaaaxx{
  font-size: 15px;
  font-family: 宋体, serif;
  color: #3f001c;
  font-weight: bold;
  margin-bottom: 10px;
}
.linktext {
  cursor: pointer;
}

.linktext:hover {
  text-decoration: underline;
}

.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

.box-card {
  width: 100%;
}

.imgsm {
  height: 500px;
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  /*align-items: end;*/
  /*flex-direction: revert;*/
  background-size: 1000px;
  background-position: center;
}
.imgmd {
   height: 500px;
   width: 100%;
   display: flex;
   align-items: center;
  background-size: 100%;
 }

</style>
