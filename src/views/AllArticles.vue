<template>
  <div class="main-container" >
    <common-header style="position: fixed;width: 100%;top:0;z-index: 10"/>
    <!--  <section class="imgsm hidden-md-and-up" :style="bgstyle">-->
    <!--  </section>-->
    <!--  <img :src="backgroundImage" alt="" style="width: 100%">-->
    <!--  <section class="imgmd hidden-sm-and-down" :style="bgstyle">-->
    <!--  </section>-->
    <h3 class="title" style="text-align: left">全部文章</h3>
    <el-row class="content" type="flex" justify="center">
      <!--    <div></div>-->
      <el-col :md="18" :sm="18" :xs="22"
              style="background:#fff;padding: 40px;box-shadow: 0px 0px 30px rgba(231,154,170,0.39);
              border-radius: 2px">
        <div v-for="article in articleData" :key="article.title">
          <h2 style="font-family: 'Lucida Handwriting',sans-serif;color: #2d0117" @click="showArticleDetail(article.url)">{{ article.title }}</h2>
          <p style="margin-left: 15px;font-weight: lighter;font-family:'微软雅黑 Light',sans-serif">加iconPath属性以显示图标
            + 添加selectPath属性以显示选中图标</p>
          <span style="float: right;font-style: italic">2022.2.16</span>
          <br/>
          <el-divider></el-divider>
        </div>
        <div style="display: flex;justify-content: center">
          <el-pagination
            background
            layout="prev, pager, next"
            :total="1000">
        </el-pagination></div>

      </el-col>
    </el-row>
    <common-footer style="margin-top: 30px" />
  </div>
</template>

<script>
import CommonHeader from "@/components/CommonHeader";
import CommonFooter from "@/components/CommonFooter";

export default {
  name: "AllArticles",
  components: {
    CommonHeader: CommonHeader,
    CommonFooter: CommonFooter
  },
  data() {
    return {

      backgroundImage: require('@/assets/9888608.png'),
      articleData: [
        {
          title: 'SpringBoot笔记',
          abstract: '加iconPath属性以显示图标 + 添加selectPath属性以显示选中图标\n',
          date: '2022.2.16',
          url: "/article"
        },
        {
          title: 'SpringBoot笔记',
          abstract: '加iconPath属性以显示图标 + 添加selectPath属性以显示选中图标\n',
          date: '2022.2.16'
        }, {
          title: 'SpringBoot笔记',
          abstract: '加iconPath属性以显示图标 + 添加selectPath属性以显示选中图标\n',
          date: '2022.2.16'
        }, {
          title: 'SpringBoot笔记',
          abstract: '加iconPath属性以显示图标 + 添加selectPath属性以显示选中图标\n',
          date: '2022.2.16'
        }
      ]
    }
  },
  methods:{
    showArticleDetail(url){
      // console.log("aaa");
      this.$router.push(url)
    }
  }
}
</script>

<style scoped>
.main-container {
  /*height: 1000px;*/
  padding-top: 100px;
  font-family: 宋体, serif;

  background-color: #A3849D;
  background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 100 1000'%3E%3Cg %3E%3Ccircle fill='%23A3849D' cx='50' cy='0' r='50'/%3E%3Cg fill='%23a88aa2' %3E%3Ccircle cx='0' cy='50' r='50'/%3E%3Ccircle cx='100' cy='50' r='50'/%3E%3C/g%3E%3Ccircle fill='%23ac90a6' cx='50' cy='100' r='50'/%3E%3Cg fill='%23b196ab' %3E%3Ccircle cx='0' cy='150' r='50'/%3E%3Ccircle cx='100' cy='150' r='50'/%3E%3C/g%3E%3Ccircle fill='%23b59cb0' cx='50' cy='200' r='50'/%3E%3Cg fill='%23baa2b5' %3E%3Ccircle cx='0' cy='250' r='50'/%3E%3Ccircle cx='100' cy='250' r='50'/%3E%3C/g%3E%3Ccircle fill='%23bea8ba' cx='50' cy='300' r='50'/%3E%3Cg fill='%23c3aebe' %3E%3Ccircle cx='0' cy='350' r='50'/%3E%3Ccircle cx='100' cy='350' r='50'/%3E%3C/g%3E%3Ccircle fill='%23c7b4c3' cx='50' cy='400' r='50'/%3E%3Cg fill='%23ccbac8' %3E%3Ccircle cx='0' cy='450' r='50'/%3E%3Ccircle cx='100' cy='450' r='50'/%3E%3C/g%3E%3Ccircle fill='%23d0c0cd' cx='50' cy='500' r='50'/%3E%3Cg fill='%23d5c6d2' %3E%3Ccircle cx='0' cy='550' r='50'/%3E%3Ccircle cx='100' cy='550' r='50'/%3E%3C/g%3E%3Ccircle fill='%23daccd7' cx='50' cy='600' r='50'/%3E%3Cg fill='%23ded3dc' %3E%3Ccircle cx='0' cy='650' r='50'/%3E%3Ccircle cx='100' cy='650' r='50'/%3E%3C/g%3E%3Ccircle fill='%23e3d9e1' cx='50' cy='700' r='50'/%3E%3Cg fill='%23e8dfe6' %3E%3Ccircle cx='0' cy='750' r='50'/%3E%3Ccircle cx='100' cy='750' r='50'/%3E%3C/g%3E%3Ccircle fill='%23ece5eb' cx='50' cy='800' r='50'/%3E%3Cg fill='%23f1ecf0' %3E%3Ccircle cx='0' cy='850' r='50'/%3E%3Ccircle cx='100' cy='850' r='50'/%3E%3C/g%3E%3Ccircle fill='%23f6f2f5' cx='50' cy='900' r='50'/%3E%3Cg fill='%23faf9fa' %3E%3Ccircle cx='0' cy='950' r='50'/%3E%3Ccircle cx='100' cy='950' r='50'/%3E%3C/g%3E%3Ccircle fill='%23FFFFFF' cx='50' cy='1000' r='50'/%3E%3C/g%3E%3C/svg%3E");
  background-attachment: fixed;
  background-size: contain;


}

.title {
  font-size: 40px;
  font-family: 宋体, serif;
  color: #3f001c;
  font-weight: lighter;
  margin-left: 10%;
  /*margin-top: 100px;*/
  /*margin-top: 3px;*/
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
