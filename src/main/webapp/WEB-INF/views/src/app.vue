<template>
    <div>
        <page-header></page-header>
        <router-view></router-view>
    </div>
</template>
<script>
import pageHeader from './components/page-header.vue';
export default {
    name: 'App',
    components: { pageHeader }
}
</script>
<style lang="scss">
    body {
        margin: 0;
        padding: 0;
        background-color: #fafafa;
    }
</style>

