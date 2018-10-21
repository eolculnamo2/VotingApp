<template>
    <div>
        <form action="/create-new-chart" type="get">
            <h1>Question</h1>
            <input name="question" type="text">
            <h2>Option</h2>
            <input name="option" type="text">
            <h2>Value</h2>
            <input name="value" type="text">
            <h2>Creator</h2>
            <input name="creator" type="text">
            <button type="submit">Submit</button>
        </form>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="scss" scoped>

</style>
