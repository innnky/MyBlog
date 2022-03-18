<template>

  <div class="main-container flex-column" style="display:flex;">
    <common-header class="w-100 position-fixed" style="z-index: 1000"/>

    <div class="web-bg " :style="bgstyle"></div>
    <h3 class="title mb-3" style="text-align: left">留言板</h3>
    <div style="width: 100%;">
      <div class="content row justify-content-center w-100 m-0" >
        <!--    <div></div>-->
        <div class="col-md-10">
          <div style="background:#fff;padding: 40px;box-shadow: 0px 0px 30px rgba(107,74,82,0.39);
              border-radius: 2px;min-height: 500px">
            <p>
              {{articleContent}}
            </p>
            <comment-area :article-id="'-1'"/>
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

export default {
  name: "MessageBoard",
  components: {
    CommonHeader: CommonHeader,
    CommonFooter: CommonFooter,
    CommentArea: CommentArea
  },
}
</script>

<style scoped>
.web-bg {
  position: fixed;
  z-index: -999;
  width: 100%;
  height: 100%;
  background: url(https://img.xiaoyou66.com/images/2020/03/01/yYCE.jpg);
  background-attachment: local;
  background-position: center;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  background-size: cover;
  background-repeat: no-repeat;
}

.title {
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