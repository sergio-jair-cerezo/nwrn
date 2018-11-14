//
//  RNEmbededHelper.swift
//  NWRN
//
//  Created by Sergio Jair Cerezo Vallejo on 11/14/18.
//  Copyright © 2018 Sergio Jair Cerezo Vallejo. All rights reserved.
//

import Foundation

class RNEmbededHelper {
    static func getRNVC(initialProperties: [NSObject : AnyObject] = [:]) -> UIViewController {
        //Suggested by official documentation
        //let jsCodeLocation = URL(string: "http://localhost:8081/index.bundle?platform=ios")
        
        //Code from original RN project
        let jsCodeLocation = RCTBundleURLProvider.sharedSettings()?.jsBundleURL(forBundleRoot: "index", fallbackResource: "")
        
        let rootView = RCTRootView(
            bundleURL: jsCodeLocation,
            moduleName: "nwrn",
            initialProperties: initialProperties,
            launchOptions: nil
        )
        let vc = UIViewController()
        vc.view = rootView
        return vc
    }
}
