<template>
    <div class="list-wrap">
        <div :key="x.title+i" v-for="(x,i) in dummyData" class="title-row">
            <a :href="'/survey/'+x.id">
                <div>
                    {{x.question}}
                </div>
            </a>
            <div>
                {{x.creator}}
            </div>
        </div>
    </div>
</template>
<script>
export default {
    name: 'home',
    data() {
        return {
            dummyData: []
        }
    },
    created(){
        fetch('/get-charts')
        .then( res => res.json() )
        .then( data => {
            this.dummyData = data
        });
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
        padding: 1em 5em;
        width: 70%;
        margin: .5em 0;
        background-color: #ffffff;
        border: 1px solid #dadada;
        border-radius: 3px;
    }
</style>
