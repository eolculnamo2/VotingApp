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

    input {
        padding: .35em 1em;
        border-radius: 3px;
        border: 1px solid #999;
    }
    button {
        outline: none;
        cursor: pointer;
    }
</style>

