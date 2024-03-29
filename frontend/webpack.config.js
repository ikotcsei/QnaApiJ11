const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
module.exports = {
  entry: './index.js', // Entry point of your application
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'bundle.js', // Output bundle file name
  },
  devtool: "source-map",   //what is this line doing ?
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader', // Use Babel for .js and .jsx files
        },
      },
      {
              test: /\.css$/,
              use: [
                'style-loader',
                'css-loader'
              ]
            }
    ],
  },
  devServer: {
      historyApiFallback: true,
      port: 8081
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './index.html', // Use this HTML file as a template
    }),
  ],
};