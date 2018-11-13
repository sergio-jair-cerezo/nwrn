//
//  SideMenuVC.swift
//  NWRN
//
//  Created by Sergio Jair Cerezo Vallejo on 11/12/18.
//  Copyright © 2018 Sergio Jair Cerezo Vallejo. All rights reserved.
//

import Foundation
import UIKit

class SideMenuVC: UIViewController {
    
    @IBOutlet weak var tableView: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.tableView.dataSource = self
    }
    
    enum MenuOption: String {
        case swift = "Swift"
        case react = "React"
        case swiftToReact = "Swift to React"
        case reactToSwift = "React to Swift"
    }
    static let menuOptions: [MenuOption] = [.swift, .react, .swiftToReact, .reactToSwift]
}

extension SideMenuVC: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return SideMenuVC.menuOptions.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = UITableViewCell(style: .default, reuseIdentifier: "menu cell")
        cell.textLabel!.text = SideMenuVC.menuOptions[indexPath.row].rawValue
        return cell
    }
}
