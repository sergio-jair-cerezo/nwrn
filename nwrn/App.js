/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import {
  createStackNavigator,
} from 'react-navigation';

import HelloWorldScreen from './screens/HelloWorldScreen';
import SecondScreen from './screens/SecondScreen';

const App = createStackNavigator({
  HelloWorld: { screen: HelloWorldScreen },
  SecondScreen: { screen: SecondScreen }
});

export default App;
