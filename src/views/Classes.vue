<template>
  <div class="main-container" >
    <common-header  style="position:fixed;left: 0;top: 0;width: 100%;z-index: 10;" />
<!--      <section class="imgsm hidden-md-and-up" :style="bgstyle">-->
<!--      </section>-->
<!--      <section class="imgmd hidden-sm-and-down" :style="bgstyle">-->
<!--      </section>-->
    <h3 class="title" style="text-align: left;">分类索引</h3>
    <div style="width: 100%;">
    <el-row class="content" type="flex" justify="center" >
      <!--    <div></div>-->
      <el-col :md="18" :sm="18" :xs="22"
              style="background:#fff;padding: 40px;box-shadow: 0px 0px 30px rgba(107,74,82,0.39);
              border-radius: 2px;min-height: 500px">
        <el-tree
            :data="treeData"
            node-key="id"
            default-expand-all
            @node-drag-start="handleDragStart"
            @node-drag-enter="handleDragEnter"
            @node-drag-leave="handleDragLeave"
            @node-drag-over="handleDragOver"
            @node-drag-end="handleDragEnd"
            @node-drop="handleDrop"
            draggable
            :allow-drop="allowDrop"
            :allow-drag="allowDrag">
        </el-tree>
      </el-col>
    </el-row>
      <common-footer style="margin-top: 30px" defaultt/></div>
<!--    <img :src="backgroundImage"  alt="" style="width: 100%;position:absolute;top:0;left: 0;z-index: -1" >-->
<!--    <div  style="width: 100%;position:absolute;top:0;left: 0;z-index: -10;background:#000;height: 1000" ></div>-->

  </div>
</template>

<script>
import CommonHeader from "@/components/CommonHeader";
import CommonFooter from "@/components/CommonFooter";
import {getAllDirs} from "@/api/data";

export default {
  name: "Classes",
  components:{
    CommonHeader: CommonHeader,
    CommonFooter: CommonFooter

  },
  created() {
    getAllDirs().then((res)=>{
      this.treeData = res.data.dirs;
    })
  }
  ,
  data(){
    return{
      treeData: [],
      defaultProps: {
        children: 'children',
        label: 'label'
      }
    }
  },
  methods:{
    handleDragStart(node, ev) {
      // console.log(ev);
      ev
      console.log('drag start', node);
    },
    handleDragEnter(draggingNode, dropNode, ev) {
      // console.log(ev);
      ev
      console.log('tree drag enter: ', dropNode.label);
    },
    handleDragLeave(draggingNode, dropNode, ev) {
      console.log(ev);
      console.log('tree drag leave: ', dropNode.label);
    },
    handleDragOver(draggingNode, dropNode, ev) {
      console.log(ev);
      console.log('tree drag over: ', dropNode.label);
    },
    handleDragEnd(draggingNode, dropNode, dropType, ev) {
      console.log(ev);
      console.log('tree drag end: ', dropNode && dropNode.label, dropType);
    },
    handleDrop(draggingNode, dropNode, dropType, ev) {
      console.log(ev);
      console.log('tree drop: ', dropNode.label, dropType);
    },
    allowDrop(draggingNode, dropNode, type) {
      if (dropNode.data.label === '二级 3-1') {
        return type !== 'inner';
      } else {
        return true;
      }
    },
    allowDrag(draggingNode) {
      return draggingNode.data.label.indexOf('三级 3-2-2') === -1;
    }
  }
}
</script>

<style scoped>

.main-container {
  /*height: 1000px;*/
  padding-top: 40px;
  font-family: 宋体, serif;
  background-color: #E5A78E;
  background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='100%25' height='100%25' viewBox='0 0 1600 800'%3E%3Cg %3E%3Cpolygon fill='%23e9b7a3' points='1600 160 0 460 0 350 1600 50'/%3E%3Cpolygon fill='%23edc8b9' points='1600 260 0 560 0 450 1600 150'/%3E%3Cpolygon fill='%23f1d8ce' points='1600 360 0 660 0 550 1600 250'/%3E%3Cpolygon fill='%23f5e9e4' points='1600 460 0 760 0 650 1600 350'/%3E%3Cpolygon fill='%23F9F9F9' points='1600 800 0 800 0 750 1600 450'/%3E%3C/g%3E%3C/svg%3E");
  background-attachment: fixed;
  background-size: cover;
  /*background-color: #FFDBE5;*/
  /*background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='200' height='200' viewBox='0 0 200 200'%3E%3Cg %3E%3Cpolygon fill='%23926a7a' points='100 57.1 64 93.1 71.5 100.6 100 72.1'/%3E%3Cpolygon fill='%23af8595' points='100 57.1 100 72.1 128.6 100.6 136.1 93.1'/%3E%3Cpolygon fill='%23926a7a' points='100 163.2 100 178.2 170.7 107.5 170.8 92.4'/%3E%3Cpolygon fill='%23af8595' points='100 163.2 29.2 92.5 29.2 107.5 100 178.2'/%3E%3Cpath fill='%23CCA1B1' d='M100 21.8L29.2 92.5l70.7 70.7l70.7-70.7L100 21.8z M100 127.9L64.6 92.5L100 57.1l35.4 35.4L100 127.9z'/%3E%3Cpolygon fill='%23b5837b' points='0 157.1 0 172.1 28.6 200.6 36.1 193.1'/%3E%3Cpolygon fill='%23d9a49c' points='70.7 200 70.8 192.4 63.2 200'/%3E%3Cpolygon fill='%23FEC7BE' points='27.8 200 63.2 200 70.7 192.5 0 121.8 0 157.2 35.3 192.5'/%3E%3Cpolygon fill='%23d9a49c' points='200 157.1 164 193.1 171.5 200.6 200 172.1'/%3E%3Cpolygon fill='%23b5837b' points='136.7 200 129.2 192.5 129.2 200'/%3E%3Cpolygon fill='%23FEC7BE' points='172.1 200 164.6 192.5 200 157.1 200 157.2 200 121.8 200 121.8 129.2 192.5 136.7 200'/%3E%3Cpolygon fill='%23b5837b' points='129.2 0 129.2 7.5 200 78.2 200 63.2 136.7 0'/%3E%3Cpolygon fill='%23FEC7BE' points='200 27.8 200 27.9 172.1 0 136.7 0 200 63.2 200 63.2'/%3E%3Cpolygon fill='%23d9a49c' points='63.2 0 0 63.2 0 78.2 70.7 7.5 70.7 0'/%3E%3Cpolygon fill='%23FEC7BE' points='0 63.2 63.2 0 27.8 0 0 27.8'/%3E%3C/g%3E%3C/svg%3E");*/
}
.el-row{
  width: 100%;
}
.title {
  font-size: 40px;
  font-family: 宋体, serif;
  color: #3f001c;
  font-weight: lighter;
  margin-left: 10%;
  margin-top: 100px;
  /*margin-top: 3px;*/
}

.imgsm {
  height: 100%;
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
