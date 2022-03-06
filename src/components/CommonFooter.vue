<template>
  <div>
  <section v-if="!defaultt"
      style="height: 100px; background:#d9949f;width: 100%;display:flex; align-items: center;justify-content: center;flex-direction: column">
    <span style="color:#600606;;font-size: 15px; margin-bottom: 2px">Developed by innnky</span>
    <span style="font-size: 10px">2022 All Rights Reserved</span>
  </section>
    <section v-if="defaultt"
             style="height: 100px; background:#d9a494;width: 100%;display:flex; align-items: center;justify-content: center;flex-direction: column">
      <span style="color:#600606;;font-size: 15px; margin-bottom: 2px">Developed by innnky</span>
      <span style="font-size: 10px">2022 All Rights Reserved</span>
    </section>
  </div>
</template>

<script>
export default {
  props:{
    defaultt:Boolean
  },
  name: "CommonFooter",
  computed:{}
}
</script>

<style scoped>

</style>
