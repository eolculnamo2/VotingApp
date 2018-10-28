<template>
    <div>
        <div class="main-header-wrap">
            <a href="/"><h1>
                MyChart
            </h1></a>
            <div>
            <a v-if="showHome" href="/"><p>
                Home
            </p></a>
             <a v-if="showNewChart" href="/new-chart"><p>
                New Chart
            </p></a>
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name: 'page-header',
    computed: {
        showHome(){
            return window.location.pathname !== '/' &&  window.location.pathname !== ''
        },
        showNewChart(){
            return window.location.pathname !== '/new-chart' && window.location.pathname !== '/new-chart/';
        }
    }
}
</script>
<style lang="scss" scoped>
    h1 {
        margin-left: 4%;
    }
    a {
        color: inherit;
        text-decoration: inherit;
        &:hover{
            color: teal;
            text-decoration: underline;
        }
    }
    .main-header-wrap {
        display: flex;
        justify-content: space-between;
        padding: 1em 5em;
    }
</style>

