<template>
    <div class="list-wrap">
        <div :key="x.title+i" v-for="(x,i) in dummyData" class="title-row">
            <a href="/survey">
                <div>
                    {{x.title}}
                </div>
            </a>
            <div>
                {{x.user}}
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name: 'home',
    data() {
        return {
            dummyData: [
                {
                    title: 'Favorite Color',
                    user: 'Rob',
                    id: '123'
                },
                {
                    title: 'Favorite Color',
                    user: 'Rob',
                    id: '223'
                },
                {
                    title: 'Favorite Color',
                    user: 'Rob',
                    id: '323'
                }
            ]
        }
    },
    created(){
        console.log("created")
        fetch('/get-homepage-data')
        .then( res => res.json() )
        .then( data => this.dummyData = data);
    }
}
</script>
<style lang="scss" scoped>
    a {
        cursor: pointer;
        color: inherit;
        text-decoration: inherit;
    }
    .list-wrap {
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
    }
    .title-row {
        display: flex;
        justify-content: space-between;
        padding: 1em;
        width: 90%;
        margin: .5em 0;
        background-color: #ffffff;
        border: 1px solid #dadada;
        border-radius: 3px;
    }
</style>
