<template>
    <div>
        <div class="main-header-wrap">
            <a href="/"><h1>
                HEADER
            </h1></a>
             <a href="/new-chart"><p>
                New Chart
            </p></a>
        </div>
    </div>
</template>
<script>
export default {
    name: 'page-header'
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
        padding: 1em;
    }
</style>

