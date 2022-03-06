<template>
  <div>
    <div class="outer-nav">

      <div v-for="m in menu" :key="m.label" class="li hidden-xs-only" @click="menuClick(m)">
        {{ m.label }}
      </div>

      <div class="search-box hidden-xs-only">
        <input type="input" class="input" placeholder="搜索文章">
        <i class="el-icon-search"></i>
      </div>

      <!--      <div class="hidden-sm-and-up">mdup</div>-->
      <el-dropdown class="hidden-sm-and-up" style="margin-left: 20px" trigger="click">
          <span class="el-dropdown-link">
            <i class="el-icon-menu el-icon--right" style="font-size: 20px"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item v-for="m in menu" :key="m.label" @click.native="menuClick(m)">{{m.label}}</el-dropdown-item>
          </el-dropdown-menu>
      </el-dropdown>
      <div class="hidden-sm-and-up" style="margin-left: auto;margin-right: 20px" @click="mobileSearch">
        <i class="el-icon-search el-dropdown-link" style="font-size: 20px"></i>
      </div>
      <!--      <el-input-->
      <!--          placeholder="搜索文章"-->
      <!--          suffix-icon="el-icon-search"-->
      <!--          v-model="input2">-->
      <!--      </el-input>-->
    </div>
  </div>
</template>

<script>
export default {
  name: "CommonHeader",
  data() {
    return {
      menu: [
        {
          label: '首页',
          path: '/',
        },
        {
          label: '全部文章',
          path: '/allArticles',
        },
        {
          label: '分类',
          path: '/classes',
        },
        {
          label: '规划',
          path: '/schedule',
        },
        {
          label: '留言板',
          path: '/',
        },

      ]
    }
  },
  methods: {
    menuClick(item) {
      this.$router.push(item.path)
    },
    mobileSearch(){
      this.$prompt('', '搜索', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
      }).then(({ value }) => {
        console.log(value);
      }).catch(() => {

      });
    }
  }
}
</script>

<style scoped>
.el-dropdown-link {
  cursor: pointer;
  color: #d298a7;
}
.el-icon-arrow-down {
  font-size: 12px;
}
.outer-nav {
  display: flex;
  width: 100%;
  height: 70px;
  align-items: center;
  /*padding-left: 60px;*/
  background: rgba(255, 232, 235, 0.7);
  font-family: 宋体, serif;
  box-shadow: 0 0 30px rgba(0, 0, 0, 0.12);
}

.li:first-child {
  margin-left: 50px;
}

.li {
  text-align: center;
  color: #7c4566;
  cursor: pointer;
  height: 50px;
  padding-left: 15px;
  padding-right: 15px;
  margin-left: 2px;
  line-height: 50px;
  border-radius: 2px;
}

.li:hover {
  color: #2d0117;
  /*font-weight: bolder;*/
  background: rgba(231, 176, 183, 0.7);

  transition: all 0.5s;
}

.search-box {
  width: 200px;
  height: 40px;
  margin-left: auto;
  margin-right: 60px;
  border-radius: 20px;
  background: rgba(140, 84, 84, 0.1);
  display: flex;
}

.input {
  border: none;
  background: none;
  outline: none;
  padding-left: 15px;
  width: 150px;
}

i {
  line-height: 40px;
  padding-right: 15px;
}

::-webkit-input-placeholder { /* WebKit browsers */
  color: #1e1e1e;
  font-size: 16px;
  font-family: 宋体, sans-serif;

}

::-moz-placeholder { /* Mozilla Firefox 19+ */
  color: #999;
  font-size: 16px;
  font-family: 宋体, sans-serif;
}

:-ms-input-placeholder { /* Internet Explorer 10+ */
  color: #999;
  font-size: 16px;
  font-family: 宋体, sans-serif;

}

</style>
