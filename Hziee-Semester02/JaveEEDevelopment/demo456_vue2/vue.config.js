// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true
// })

module.exports = {
  devServer: {
    port: 8080,
    host: '172.20.10.2',
    open: true,
    https: false,
    proxy: {
      '/BossWebApi': {
        target: 'http://127.0.0.1:8080/',
        changeOrigin: true,
        pathRewrite: {
          '^/BossWebApi': ''
        }
      },
    }
  },
}